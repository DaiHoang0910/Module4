package com.example.mail.Service;

import com.example.mail.Model.Config;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {
    private Config config = new Config();

    public Config getConfig() {
        if (config.getLanguage() == null) {
            config.setLanguage("English");
            config.setPageSize(25);
            config.setSpamFilter(false);
            config.setSignature("Thor\nKing, Asgard");
        }
        return config;
    }

    public void updateConfig(Config newConfig) {
        this.config = newConfig;
    }
}
