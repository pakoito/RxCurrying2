
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

import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func1;

/**
 * Created by Paco on 14/02/2016. See LICENSE.md
 */
public class RxCurryingConsumerTest {
    @Test
    public void curry() throws Exception {
        Func1<Integer, Action1<Integer>> variable = RxCurryingConsumer
                .curry(new Action2<Integer, Integer>() {
                    @Override
                    public void call(Integer first, Integer second) {
                        Assert.assertEquals(5, first + second);
                    }
                });
        Action1<Integer> firstForm = variable.call(3);
        firstForm.call(2);
    }
}
