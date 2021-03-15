package com.radcortez.quarkus.config;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class ConfigTest {
    @Test
    void locations() {
        assertConfig("simple.property", "from-application");
        assertConfig("override.property", "from-config");
        assertConfig("override.profile.property", "from-config-test");
        assertConfig("override.profile.main.property", "from-config-%test");

        assertConfig("external.property", "from-external");
        assertConfig("override.external.profile.property", "from-external-test");
    }

    private static void assertConfig(String name, String expected) {
        given()
            .get("/config/{name}", name)
            .then()
            .statusCode(OK.getStatusCode())
            .body("value", equalTo(expected));
    }
}
