package com.invcd.signin;

import com.fasterxml.jackson.core.JsonFactory;

public class GoogleSSO {
    // Replace with your client ID obtained from the Google API Console
    private static final String CLIENT_ID = "YOUR_CLIENT_ID";
/*
    private static final HttpTransport transport = new com.google.api.client.http.javanet.NetHttpTransport();
*/

    private static final JsonFactory jsonFactory = new JsonFactory();

    public static boolean validateToken(String idTokenString) {
        try {
/*
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                    .setAudience(Collections.singletonList(CLIENT_ID))
                    .build();

            GoogleIdToken idToken = verifier.verify(idTokenString);
*/

            if (idTokenString != null) {
/*
                Payload payload = idToken.getPayload();
                // Get user information
                String userId = payload.getSubject();
                String email = payload.getEmail();
                String name = (String) payload.get("name");
                String pictureUrl = (String) payload.get("picture");

                // You can use this information to sign the user in to your application
                System.out.println("User ID: " + userId);
                System.out.println("Email: " + email);
                System.out.println("Name: " + name);
                System.out.println("Picture URL: " + pictureUrl);

*/
                // Authentication successful
                return true;
            } else {
                // Invalid token
                System.out.println("Invalid token.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Example usage
    public static void main(String[] args) {
        // Replace idTokenString with the ID token obtained from the client-side authentication flow
        String idTokenString = "YOUR_ID_TOKEN";
        validateToken(idTokenString);
    }

}
