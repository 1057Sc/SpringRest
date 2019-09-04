package org.sc.lazy;

import org.junit.Test;
import org.sc.util.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 * Created by duizhuang on 9/2/2019.
 */
public class Region {

    @Lazy
    @Autowired
    private City city;

    public Region() {
        System.out.println("Region bean initialized");
    }

    public City getCityInstance() {
        return city;
    }


    @Test
    public void givenLazyAnnotation_whenAutowire_thenLazyBean() {
        // load up ctx appication context
        Region region = SpringContextHolder.getBean(Region.class);
        region.getCityInstance();
    }
}
