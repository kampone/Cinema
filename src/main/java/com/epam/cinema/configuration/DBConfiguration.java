package com.epam.cinema.configuration;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.support.incrementer.H2SequenceMaxValueIncrementer;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DBConfiguration {
    @Bean
    @Primary
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2)
                .setName("local")
                .addScript("localdb/schema.sql")
                .addScript("localdb/initial-data.sql")
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
    public H2SequenceMaxValueIncrementer auditoriumIncrementer(@Autowired DataSource dataSource){
        H2SequenceMaxValueIncrementer incrementer = new H2SequenceMaxValueIncrementer();
        incrementer.setDataSource(dataSource);
        incrementer.setIncrementerName("auditorium_sequence");
        return incrementer;
    }

    @Bean
    public H2SequenceMaxValueIncrementer seatIncrementer(@Autowired DataSource dataSource){
        H2SequenceMaxValueIncrementer incrementer = new H2SequenceMaxValueIncrementer();
        incrementer.setDataSource(dataSource);
        incrementer.setIncrementerName("seat_sequence");
        return incrementer;
    }

    @Bean
    public H2SequenceMaxValueIncrementer eventIncrementer(@Autowired DataSource dataSource){
        H2SequenceMaxValueIncrementer incrementer = new H2SequenceMaxValueIncrementer();
        incrementer.setDataSource(dataSource);
        incrementer.setIncrementerName("event_sequence");
        return incrementer;
    }

    @Bean
    public H2SequenceMaxValueIncrementer userIncrementer(@Autowired DataSource dataSource){
        H2SequenceMaxValueIncrementer incrementer = new H2SequenceMaxValueIncrementer();
        incrementer.setDataSource(dataSource);
        incrementer.setIncrementerName("user_sequence");
        return incrementer;
    }

    @Bean
    public H2SequenceMaxValueIncrementer ticketIncrementer(@Autowired DataSource dataSource){
        H2SequenceMaxValueIncrementer incrementer = new H2SequenceMaxValueIncrementer();
        incrementer.setDataSource(dataSource);
        incrementer.setIncrementerName("ticket_sequence");
        return incrementer;
    }

    @Bean
    @Scope("prototype")
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
