// package com.projects.tidystore.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
// import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
// import org.springframework.http.HttpMethod;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;

// import com.projects.tidystore.entity.Item;
// import com.projects.tidystore.entity.Room;

// @Configuration
// public class MyDataRestConfig implements RepositoryRestConfigurer {

//     @Override
//     public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config,
//             CorsRegistry cors) {
//         HttpMethod[] theUnsupportedActions = { HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE };
//         config.getExposureConfiguration()
//                 .forDomainType(Item.class)
//                 .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
//                 .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

//         config.getExposureConfiguration()
//                 .forDomainType(Room.class)
//                 .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
//                 .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
//     }
// }
