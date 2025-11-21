package com.streamhive;

import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    public static boolean checkAccess(User user, Content content) {
        if ("4K".equals(content.getQuality())) {
            return "PREMIUM".equalsIgnoreCase(user.getPlan());
        }
        return true; // Todos pueden ver HD/SD
    }
}

// Clases auxiliares (POJOs)
class User {
    private String username;
    private String plan;

    public User(String username, String plan) {
        this.username = username;
        this.plan = plan;
    }
    public String getPlan() { return plan; }
}

class Content {
    private String title;
    private String quality;

    public Content(String title, String quality) {
        this.title = title;
        this.quality = quality;
    }
    public String getQuality() { return quality; }
}
