package com.project.staragile.insureme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PolicyServiceTests {

    @Mock
    private PolicyRepository policyRepository;

    @InjectMocks
    private PolicyService policyService;

    @Test
    void testCreatePolicy() {
        Policy expectedPolicy = new Policy(1, "Shubham", "Individual", 10000, "10-Sep-2021", "10-Sep-2022");

        when(policyRepository.save(expectedPolicy)).thenReturn(expectedPolicy);

        assertEquals(expectedPolicy, policyService.CreatePolicy());
    }

    @Test
    void testRegisterPolicy() {
        Policy inputPolicy = new Policy(1, "Shubham", "Individual", 10000, "10-Sep-2021", "10-Sep-2022");
        Policy expectedPolicy = new Policy(1, "Shubham", "Individual", 10000, "10-Sep-2021", "10-Sep-2022");

        when(policyRepository.save(inputPolicy)).thenReturn(expectedPolicy);

        assertEquals(expectedPolicy, policyService.registerPolicy(inputPolicy));
    }

    @Test
    void testGetPolicyDetails() {
        int policyId = 1;
        Policy expectedPolicy = new Policy(1, "Shubham", "Individual", 10000, "10-Sep-2021", "10-Sep-2022");

        when(policyRepository.findById(policyId)).thenReturn(java.util.Optional.of(expectedPolicy));

        assertEquals(expectedPolicy, policyService.getPolicyDetails(policyId));
    }
}
