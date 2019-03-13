package me.mupu.ibikehda;

import lombok.val;
import lombok.var;
import me.mupu.ibikehda.util.HashPasswordEncoder;
import org.junit.Test;


public class GeneralTest {

    @Test
    public void test() {

    }

    @Test
    public void hashPasswordEncoder() {
        var encoder = new HashPasswordEncoder();
        val pw = "guntach";
        val compare = "guntach";

        System.out.println(encoder.matches(compare, encoder.encode(pw)));
    }

}
