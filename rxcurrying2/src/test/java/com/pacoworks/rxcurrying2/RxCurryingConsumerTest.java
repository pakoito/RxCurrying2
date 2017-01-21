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

import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class RxCurryingConsumerTest {
    @Test
    public void curry() throws Exception {
        Function<Integer, Consumer<Integer>> variable = RxCurryingConsumer
                .curry(new BiConsumer<Integer, Integer>() {
                    @Override
                    public void accept(Integer first, Integer second) {
                        Assert.assertEquals(5, first + second);
                    }
                });
        Consumer<Integer> firstForm = variable.apply(3);
        firstForm.accept(2);
    }
}
