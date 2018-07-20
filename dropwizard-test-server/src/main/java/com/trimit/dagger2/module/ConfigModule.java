/*
 * (c) Copyright 2018 Trimit. All rights reserved.
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

package com.trimit.dagger2.module;

import com.trimit.configuration.DropwizardTestConfiguration;
import dagger.Module;
import dagger.Provides;
import java.util.Map;

@Module
public class ConfigModule {
    private final DropwizardTestConfiguration configuration;

    public ConfigModule(DropwizardTestConfiguration configuration) {
        this.configuration = configuration;
    }

    @Provides
    final Map<String, String> provideServiceDiscovery() {
        return configuration.getServiceDiscovery();
    }
}
