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
            City marrakech = new City();
            marrakech.setName("Marrakech");
            marrakech.setDescription("Known as the 'Red City', Marrakech is famous for its historical palaces, bustling souks, and vibrant culture. Visitors can explore iconic sites like Jemaa el-Fnaa, the Koutoubia Mosque, and the Majorelle Garden.");
            marrakech.setImageUrl("marakkech.jpg"); // Replace with actual URL
            cityRepository.save(marrakech);

            City casablanca = new City();
            casablanca.setName("Casablanca");
            casablanca.setDescription("Casablanca is Morocco's largest city and economic hub, blending modernity with historic charm. The Hassan II Mosque, one of the largest in the world, is a major attraction, as well as the Corniche seafront and the Royal Palace.");
            casablanca.setImageUrl("casablanca.jpg"); // Replace with actual URL
            cityRepository.save(casablanca);

            City fez = new City();
            fez.setName("Fez");
            fez.setDescription("Fez is the spiritual heart of Morocco, home to the world's oldest university and a labyrinthine medina (Fez el-Bali), known for its medieval architecture, bustling markets, and traditional tanneries.");
            fez.setImageUrl("fez.jpg"); // Replace with actual URL
            cityRepository.save(fez);

            City chefchaouen = new City();
            chefchaouen.setName("Chefchaouen");
            chefchaouen.setDescription("Often referred to as the 'Blue Pearl' of Morocco, Chefchaouen is known for its blue-painted streets and tranquil vibe. It is surrounded by the stunning Rif Mountains, making it a popular spot for nature lovers and photographers.");
            chefchaouen.setImageUrl("chefchaouen.jpg"); // Replace with actual URL
            cityRepository.save(chefchaouen);

            City essaouira = new City();
            essaouira.setName("Essaouira");
            essaouira.setDescription("Essaouira is a charming coastal city known for its laid-back atmosphere, historic medina, and beautiful beaches. The fortified walls, souks, and fresh seafood make it a must-visit destination for a relaxing seaside escape.");
            essaouira.setImageUrl("essaouira.jpg"); // Replace with actual URL
            cityRepository.save(essaouira);

            City agadir = new City();
            agadir.setName("Agadir");
            agadir.setDescription("Agadir is famous for its long sandy beaches and sunny climate, making it a favorite resort destination. Visitors enjoy water sports, promenades along the marina, and exploring the nearby Atlas Mountains.");
            agadir.setImageUrl("agadir.jpg"); // Replace with actual URL
            cityRepository.save(agadir);

            City meknes = new City();
            meknes.setName("Meknes");
            meknes.setDescription("Meknes is one of Morocco’s imperial cities, known for its grand gates, palaces, and the historical medina. It is less crowded but equally rich in history, with landmarks like the Bab Mansour gate and the Mausoleum of Moulay Ismail.");
            meknes.setImageUrl("meknes.jpg"); // Replace with actual URL
            cityRepository.save(meknes);

            City rabat = new City();
            rabat.setName("Rabat");
            rabat.setDescription("The capital of Morocco, Rabat offers a mix of modern attractions and historical landmarks. Highlights include the Royal Palace, Hassan Tower, and the Kasbah of the Udayas, as well as beautiful coastal views.");
            rabat.setImageUrl("rabat.jpg"); // Replace with actual URL
            cityRepository.save(rabat);

            City tangier = new City();
            tangier.setName("Tangier");
            tangier.setDescription("Tangier is a city of unique charm, positioned on the edge of Africa, where the Mediterranean meets the Atlantic. Known for its multicultural heritage, Tangier features attractions such as the Caves of Hercules, Kasbah Museum, and stunning views of the Strait of Gibraltar.");
            tangier.setImageUrl("Tangier.jpg"); // Replace with actual URL
            cityRepository.save(tangier);

            City ouarzazate = new City();
            ouarzazate.setName("Ouarzazate");
            ouarzazate.setDescription("Often called the 'Gateway to the Sahara', Ouarzazate is known for its film studios and as a starting point for desert adventures. Visit the iconic Aït Benhaddou, a UNESCO World Heritage site, and explore traditional kasbahs.");
            ouarzazate.setImageUrl("ouarzazate.jpg"); // Replace with actual URL
            cityRepository.save(ouarzazate);

            System.out.println("Sample city data loaded successfully.");
        } else {
            System.out.println("Cities are already loaded in the database.");
        }
    }
}
