/*
 * (c) Copyright 2018 Trimit All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.trimit;

import com.trimit.configuration.DropwizardTestConfiguration;
import com.trimit.dagger2.component.DaggerServerComponent;
import com.trimit.dagger2.component.ServerComponent;
import com.trimit.dagger2.module.ConfigModule;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Main entry point to the dropwizard-test API server.
 */
public final class DropwizardTestApplication extends Application<DropwizardTestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardTestApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<DropwizardTestConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/app", "/", "index.html"));
    }

    @Override
    public void run(final DropwizardTestConfiguration configuration, final Environment environment) {
        ServerComponent serverComponent = DaggerServerComponent.builder()
                .configModule(new ConfigModule(configuration))
                .build();


        environment.jersey().setUrlPattern("/api/*");
        environment.jersey().register(serverComponent.helloWorldResource());

    }
}
