package com.example.tourism;

import com.example.tourism.models.City;
import com.example.tourism.repositories.CityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class DataLoader implements CommandLineRunner {

    private final CityRepository cityRepository;

    public DataLoader(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCityData();
    }

    private void loadCityData() {
        if (cityRepository.count() == 0) {
            City hanoi = new City();
            hanoi.setName("Hà Nội");
            hanoi.setDescription("Hà Nội là thủ đô của Việt Nam, nổi bật với những di tích lịch sử, văn hóa cổ kính như Hồ Gươm, Lăng Bác và các khu phố cổ. Hà Nội cũng là nơi giao thoa giữa truyền thống và hiện đại, với các công trình kiến trúc độc đáo và ẩm thực phong phú.");
            hanoi.setImageUrl("hanoi.jpg");
            cityRepository.save(hanoi);

            City halong = new City();
            halong.setName("Hạ Long");
            halong.setDescription("Hạ Long là một trong những kỳ quan thiên nhiên thế giới với hơn 1.600 đảo đá vôi lớn nhỏ. Đây là điểm đến lý tưởng cho những ai yêu thích khám phá cảnh đẹp thiên nhiên và tham gia các hoạt động như chèo thuyền kayak, du lịch vịnh.");
            halong.setImageUrl("halong.jpg");
            cityRepository.save(halong);

            City hoiAn = new City();
            hoiAn.setName("Hội An");
            hoiAn.setDescription("Phố cổ Hội An nổi tiếng với những con phố cổ kính, các ngôi nhà mang đậm dấu ấn lịch sử và văn hóa. Đây cũng là nơi hội tụ các giá trị nghệ thuật với những cửa hàng thủ công, các món ăn ngon và không gian yên bình.");
            hoiAn.setImageUrl("hoi-an.jpg");
            cityRepository.save(hoiAn);

            City sapa = new City();
            sapa.setName("Sapa");
            sapa.setDescription("Sapa nổi tiếng với những thửa ruộng bậc thang tuyệt đẹp, khí hậu mát mẻ và các dân tộc thiểu số sinh sống. Du khách có thể trekking lên các đỉnh núi cao như Fansipan, tham quan các bản làng, và khám phá văn hóa độc đáo của người dân nơi đây.");
            sapa.setImageUrl("sapa.jpg");
            cityRepository.save(sapa);

            City daNang = new City();
            daNang.setName("Đà Nẵng");
            daNang.setDescription("Đà Nẵng là thành phố biển nổi tiếng với bãi biển Mỹ Khê đẹp, các cây cầu đặc sắc như Cầu Rồng và Cầu Sông Hàn. Ngoài ra, Đà Nẵng còn là điểm khởi đầu để khám phá các địa điểm như Ngũ Hành Sơn, Bà Nà Hills.");
            daNang.setImageUrl("da-nang.jpg");
            cityRepository.save(daNang);

            City phuQuoc = new City();
            phuQuoc.setName("Phú Quốc");
            phuQuoc.setDescription("Phú Quốc là hòn đảo lớn nhất Việt Nam, nổi tiếng với bãi biển đẹp, nước trong xanh, và các khu nghỉ dưỡng cao cấp. Đảo Phú Quốc còn được biết đến với các sản phẩm như nước mắm, tiêu, và các món hải sản tươi ngon.");
            phuQuoc.setImageUrl("phu-quoc.jpg");
            cityRepository.save(phuQuoc);

            City nhaTrang = new City();
            nhaTrang.setName("Nha Trang");
            nhaTrang.setDescription("Nha Trang là thành phố biển nổi tiếng với những bãi biển dài, cát trắng và nước biển trong xanh. Đây là điểm đến lý tưởng cho những ai yêu thích các hoạt động thể thao dưới nước và tham quan các điểm du lịch như Vinpearl Land, Hòn Mun, và Tháp Bà Ponagar.");
            nhaTrang.setImageUrl("nha-trang.jpg");
            cityRepository.save(nhaTrang);

            City hue = new City();
            hue.setName("Huế");
            hue.setDescription("Huế là cố đô của Việt Nam, nổi bật với các di tích lịch sử và văn hóa như Đại Nội, các lăng tẩm của các vua triều Nguyễn. Huế còn nổi bật với ẩm thực đặc sắc và những dòng sông thơ mộng.");
            hue.setImageUrl("hue.jpg");
            cityRepository.save(hue);

            City muiNe = new City();
            muiNe.setName("Mũi Né");
            muiNe.setDescription("Mũi Né nổi tiếng với những đồi cát đỏ, biển xanh và những khu nghỉ dưỡng cao cấp. Đây là điểm đến lý tưởng cho những ai yêu thích thể thao mạo hiểm như lướt ván diều và khám phá các địa điểm tự nhiên.");
            muiNe.setImageUrl("mui-ne.jpg");
            cityRepository.save(muiNe);

            System.out.println("Sample city data loaded successfully.");
        } else {
            System.out.println("Cities are already loaded in the database.");
        }
    }
}
