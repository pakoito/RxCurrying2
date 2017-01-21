/*
 * Copyright (c) pakoito 2017
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pacoworks.rxcurrying2;

import org.junit.Assert;
import org.junit.Test;

import io.reactivex.functions.Function;
import io.reactivex.functions.Function5;

public class RxCurryingFunctionTest {
    @Test
    public void curry() throws Exception {
        Function<String, Function<String, Function<String, Function<String, Function<String, String>>>>> secondVariable = RxCurryingFunction
                .curry(new Function5<String, String, String, String, String, String>() {
                    @Override
                    public String apply(String first, String second, String third, String fourth,
                            String fifth) {
                        return first + second + third + fourth + fifth;
                    }
                });
        String result = secondVariable.apply("Hello ").apply("This ").apply("Is ").apply("Curried ")
                .apply("Func");
        Assert.assertEquals("Hello This Is Curried Func", result);
    }
}
