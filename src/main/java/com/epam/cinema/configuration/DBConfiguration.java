package com.epam.cinema.configuration;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DBConfiguration {
    @Bean
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2)
                .setName("local")
                .addScript("localdb/schema.sql")
                .addScript("localdb/test-data.sql")
                .build();
    }

    /**
     * starts up a GUI for h2 on localhost:8082
     *
     * @return a Server object
     * @throws SQLException SQLException
     */
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server startDBManager() throws SQLException {
        return Server.createWebServer();
    }

    @Bean
    @Scope("prototype")
    public JdbcTemplate getJdbcTemplate(@Autowired DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
