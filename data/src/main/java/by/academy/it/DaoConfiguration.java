package by.academy.it;

import by.academy.it.chat.pojo.PrivateChat;
import by.academy.it.chat.pojo.PrivateMessage;
import by.academy.it.topic.pojo.Topic;
import by.academy.it.topic.pojo.TopicMessage;
import by.academy.it.user.pojo.AppUser;
import by.academy.it.user.pojo.AppUserCredentials;
import by.academy.it.user.pojo.BlackListOwners;
import by.academy.it.user.pojo.BlockedUsers;
import by.academy.it.user.pojo.Friends;
import by.academy.it.user.pojo.AppUserContactDetails;
import by.academy.it.user.pojo.UserRole;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:ds.properties")
@ComponentScan(basePackages = "by.academy.it.user")
public class DaoConfiguration {

    @Autowired
    Environment env;

    @Bean
    public Properties dataSourceProperties() {
        Properties properties = new Properties();
        properties.setProperty("useSSL", env.getProperty("useSSL"));
        properties.setProperty("serverTimezone", env.getProperty("serverTimezone"));
        properties.setProperty("createDatabaseIfNotExist", env.getProperty("createDatabaseIfNotExist"));
        properties.setProperty("characterEncoding", env.getProperty("characterEncoding"));
        return properties;
    }


    @Bean
    public DataSource chattyDogDataSource(Properties dataSourceProperties) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://dog-chatty.cmolwpyrnjpy.us-east-1.rds.amazonaws.com:3306/chatty_dog");
        config.setUsername("root");
        config.setPassword("awdqse123");
        config.setDriverClassName(env.getProperty("jdbc.driver"));
        config.setMaximumPoolSize(env.getProperty("pool_size", Integer.class));
        config.setDataSourceProperties(dataSourceProperties);
        return new HikariDataSource(config);
    }


    @Bean
    public LocalSessionFactoryBean chattyDogSessionFactory(
            @Qualifier("chattyDogDataSource") DataSource dataSource) {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        properties.setProperty("show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        sessionFactory.setHibernateProperties(properties);
        sessionFactory.setAnnotatedClasses(BlackListOwners.class, BlockedUsers.class, Friends.class,
                AppUserContactDetails.class, UserRole.class, AppUser.class, PrivateMessage.class, PrivateChat.class, AppUserCredentials.class,
                TopicMessage.class, Topic.class);
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(@Qualifier("chattyDogSessionFactory") SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}
