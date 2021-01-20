package icu.jogeen.fakerplugin.service;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @Author jogeen
 * @Date 15:57 2021/1/19
 * @Version v1.0
 * @DescriptionLo
 */
public class FakerServiceFactory {

    private static Map<Locale, FakerService> serviceMap = new ConcurrentHashMap<Locale, FakerService>();

    public static FakerService getFakerService(Locale locale) {
        FakerService fakerService = serviceMap.get(locale);
        if (fakerService == null) {
            fakerService = new BaseFakerService(locale);
            serviceMap.put(locale, fakerService);
        }
        return fakerService;
    }
}
