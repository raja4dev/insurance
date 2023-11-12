package com.project.staragile.insureme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PolicyControllerTests {

    @Mock
    private PolicyService policyService;

    @InjectMocks
    private PolicyController policyController;

    @Test
    void testSayHello() {
        assertEquals("hello", policyController.sayHello());
    }

    @Test
    void testCreatePolicy() {
        Policy expectedPolicy = new Policy(1, "Shubham", "Individual", 10000, "10-Sep-2021", "10-Sep-2022");
        when(policyService.CreatePolicy()).thenReturn(expectedPolicy);

        assertEquals(expectedPolicy, policyController.createPolicy());
    }

    @Test
    void testCreatePolicyWithRequestBody() {
        Policy inputPolicy = new Policy(1, "Shubham", "Individual", 10000, "10-Sep-2021", "10-Sep-2022");
        Policy expectedPolicy = new Policy(1, "Shubham", "Individual", 10000, "10-Sep-2021", "10-Sep-2022");

        when(policyService.registerPolicy(inputPolicy)).thenReturn(expectedPolicy);

        assertEquals(expectedPolicy, policyController.createPolicy(inputPolicy));
    }

    @Test
    void testGetPolicyDetails() {
        int policyId = 1;
        Policy expectedPolicy = new Policy(1, "Shubham", "Individual", 10000, "10-Sep-2021", "10-Sep-2022");

        when(policyService.getPolicyDetails(policyId)).thenReturn(expectedPolicy);

        assertEquals(expectedPolicy, policyController.getPolicyDetails(policyId));
    }
}
