package com.streamhive;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SubscriptionTest {

    @Test
    void premiumUserShouldAccess4K() {
        // Arrange
        User user = new User("admin", "PREMIUM");
        Content video = new Content("Matrix", "4K");

        // Act
        boolean canWatch = SubscriptionService.checkAccess(user, video);

        // Assert
        assertTrue(canWatch, "El usuario Premium debe poder ver contenido 4K");
    }

    @Test
    void basicUserShouldNotAccess4K() {
        User user = new User("guest", "BASIC");
        Content video = new Content("Matrix", "4K");
        
        boolean canWatch = SubscriptionService.checkAccess(user, video);
        
        assertFalse(canWatch, "El usuario Básico NO debe ver 4K");
    }
}
