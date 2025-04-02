package com.example.heroapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArenaRegistrationServiceImpl implements ArenaRegistrationService {

    private static final Logger logger = LoggerFactory.getLogger(ArenaRegistrationServiceImpl.class);

    private final RestTemplate restTemplate = new RestTemplate();

    // adresse du serveur
    private static final String ARENA_URL = "http://51.210.251.137/";

    @Override
    public void register() {
        List<Map<String, String>> payload = new ArrayList<>();

        Map<String, String> id1 = new HashMap<>();
        id1.put("key", "GD@evweb");
        id1.put("value", "Gaëtan");
        payload.add(id1);

        Map<String, String> id2 = new HashMap<>();
        id2.put("key", "baseUrl");
        id2.put("value", "http://localhost:8082");
        payload.add(id2);

        try {
            restTemplate.postForEntity(ARENA_URL, payload, String.class);
            logger.info("API connection à l'arène réussi.");
        } catch (Exception e) {
            logger.error("Échec d'enregistrement à l'arène.", e);
        }
    }
}