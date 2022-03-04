package com.samples.steps;

import com.google.common.collect.ImmutableMap;
import com.samples.enums.Environments;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ChromeSteps extends BaseSteps{

    protected ChromeSteps(Environments environment) {
        super(environment);
    }

    @Override
    protected MutableCapabilities initCapabilities() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        //options.addArguments("--headless");
        return options;
    }

    @Override
    public void simulateSlowNetworkConnection() {
        CommandExecutor executor = getChromeDriver().getCommandExecutor();
        Map<String, Object> networkConditions = new HashMap<>();
        networkConditions.put("offline", false);
        networkConditions.put("latency", 5);
        networkConditions.put("download_throughput", 500);
        networkConditions.put("upload_throughput", 1024);
        try {
            executor.execute(new Command(getChromeDriver().getSessionId(), "setNetworkConditions", ImmutableMap.of("network_conditions", ImmutableMap.copyOf(networkConditions))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
