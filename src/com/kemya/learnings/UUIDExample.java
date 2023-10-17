package com.kemya.learnings;
import java.util.UUID;

public class UUIDExample {
    public static void main(String[] args) {
        UUID uuid= UUID.fromString("49e1f0d2-3684-4fa7-8c4a-19557466fd10");
        System.out.println(uuid);
        System.out.println(uuid.getLeastSignificantBits());
        System.out.println(uuid.variant());
        System.out.println(uuid.version());
       byte[] byteArray={1,2,3};
       UUID uuid1=UUID.nameUUIDFromBytes(byteArray);
        System.out.println(uuid1);
        System.out.println(uuid.variant());
        System.out.println(uuid.version());
        //5289df73-7df5-3326-bcdd-22597afb1fac

    }
}
