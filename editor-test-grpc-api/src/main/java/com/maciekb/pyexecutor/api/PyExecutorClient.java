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

package com.maciekb.pyexecutor.api;

import com.maciekb.pyexecutor.PyExecutorGrpc;
import com.maciekb.pyexecutor.Pyexecutor;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class PyExecutorClient {
    private final ManagedChannel channel;
    private final PyExecutorGrpc.PyExecutorBlockingStub blockingStub;

    public PyExecutorClient(ManagedChannel channel) {
        this.channel = channel;
        this.blockingStub = PyExecutorGrpc.newBlockingStub(channel);
    }

    public final String execute(String code, String expression) {
        Pyexecutor.ExecuteResponse response = blockingStub.execute(Pyexecutor.ExecuteRequest.newBuilder()
                .setCommand(code)
                .setExpression(expression)
                .build());

        return response.getResult();
    }

    public static void main(String[] args) {
        PyExecutorClient client = new PyExecutorClient(ManagedChannelBuilder
                .forAddress("localhost", 8443)
                .usePlaintext()
                .build());

        System.out.println(client.execute("x=5; import pandas as pd", "pd.DataFrame(data={'a':[1,2,3]})"));
    }
}
