package tech.donau.course.config;

import io.quarkus.arc.config.ConfigProperties;

import javax.validation.constraints.Size;
import java.util.Optional;

@ConfigProperties(prefix = "greeting")
public class GreetingConfig {
    @Size(max = 10)
    private String greet; // greeting.greet
    private Optional<String> prefix; // greeting.prefix
    private String suffix = "!!!"; // greeting.suffix
    private CountryConfig country;

    public String getGreet() {
        return greet;
    }

    public void setGreet(String greet) {
        this.greet = greet;
    }

    public Optional<String> getPrefix() {
        return prefix;
    }

    public void setPrefix(Optional<String> prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public CountryConfig getCountry() {
        return country;
    }

    public void setCountry(CountryConfig country) {
        this.country = country;
    }

    public static class CountryConfig {
        String name;
        int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
