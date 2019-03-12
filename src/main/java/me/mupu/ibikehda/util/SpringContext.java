package me.mupu.ibikehda.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * Used to access beans from non-spring managed Classes.
     * Example: SpringContext.getBean(EntityManagerFactory.class)
     */
    public static <T extends Object> T getBean(Class<T> beanClass) {
        return applicationContext.getBean(beanClass);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        // store ApplicationContext reference to access required beans later on
        SpringContext.applicationContext = context;
    }
}