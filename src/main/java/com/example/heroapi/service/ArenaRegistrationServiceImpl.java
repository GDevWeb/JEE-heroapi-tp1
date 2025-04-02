package com.example.heroapi.service;

import com.example.heroapi.dto.ArenaRegistrationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ArenaRegistrationServiceImpl implements ArenaRegistrationService {

    private static final Logger logger = LoggerFactory.getLogger(ArenaRegistrationServiceImpl.class);

    private final RestTemplate restTemplate = new RestTemplate();

   // private static final String ARENA_URL = "http://51.210.251.137/arena/register"; //ali
   private static final String ARENA_URL = "https://webhook.site/6923c6b7-92ad-4e2f-ba69-476222f2bcc5";

    @Override
    public void register() {
        ArenaRegistrationRequest request = new ArenaRegistrationRequest(
                "Gaëtan DevWeb",
                "http://localhost:8082"
        );

       /* ObjectMapper mapper = new ObjectMapper();
        String jsonPayload = mapper.writeValueAsString(payload);
        logger.info("Payload envoyé à l’arène : {}", jsonPayload); */

        try {
            restTemplate.postForEntity(ARENA_URL, request, Void.class);
            logger.info("✅ Enregistrement à l'arène réussi.");
        } catch (Exception e) {
            logger.error("❌ Échec d'enregistrement à l'arène.", e);
        }
    }
}
