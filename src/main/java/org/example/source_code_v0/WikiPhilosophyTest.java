package org.example.source_code_v0;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;

public class WikiPhilosophyTest {

    @Test
    public void testMain() {
        String[] args = {};
        try {
            WikiPhilosophy.main(args);
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

}
