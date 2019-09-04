package org.sc.lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Created by duizhuang on 9/2/2019.
 */
@Lazy
@Component
public class City {
    public City() {
        System.out.println("City bean initialized");
    }
}