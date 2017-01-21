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

import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;

/**
 * Helper class to curry FuncN objects
 *
 * @author pakoito
 */
public class RxCurryingFunction {
    private RxCurryingFunction() {
        // No instances
    }

    public static <A, B, R> Function<A, Function<B, R>> curry(final BiFunction<A, B, R> func) {
        return new Function<A, Function<B, R>>() {
            @Override
            public Function<B, R> apply(final A a) throws Exception {
                return new Function<B, R>() {
                    @Override
                    public R apply(final B b) throws Exception {
                        return func.apply(a, b);
                    }
                };
            }
        };
    }

    public static <A, B, C, R> Function<A, Function<B, Function<C, R>>> curry(final Function3<A, B, C, R> func) {
        return new Function<A, Function<B, Function<C, R>>>() {
            @Override
            public Function<B, Function<C, R>> apply(final A a) throws Exception {
                return new Function<B, Function<C, R>>() {
                    @Override
                    public Function<C, R> apply(final B b) throws Exception {
                        return new Function<C, R>() {
                            @Override
                            public R apply(final C c) throws Exception {
                                return func.apply(a, b, c);
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C, D, R> Function<A, Function<B, Function<C, Function<D, R>>>> curry(
            final Function4<A, B, C, D, R> func) {
        return new Function<A, Function<B, Function<C, Function<D, R>>>>() {
            @Override
            public Function<B, Function<C, Function<D, R>>> apply(final A a) throws Exception {
                return new Function<B, Function<C, Function<D, R>>>() {
                    @Override
                    public Function<C, Function<D, R>> apply(final B b) throws Exception {
                        return new Function<C, Function<D, R>>() {
                            @Override
                            public Function<D, R> apply(final C c) throws Exception {
                                return new Function<D, R>() {
                                    @Override
                                    public R apply(final D d) throws Exception {
                                        return func.apply(a, b, c, d);
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C, D, E, R> Function<A, Function<B, Function<C, Function<D, Function<E, R>>>>> curry(
            final Function5<A, B, C, D, E, R> func) {
        return new Function<A, Function<B, Function<C, Function<D, Function<E, R>>>>>() {
            @Override
            public Function<B, Function<C, Function<D, Function<E, R>>>> apply(final A a) throws Exception {
                return new Function<B, Function<C, Function<D, Function<E, R>>>>() {
                    @Override
                    public Function<C, Function<D, Function<E, R>>> apply(final B b) throws Exception {
                        return new Function<C, Function<D, Function<E, R>>>() {
                            @Override
                            public Function<D, Function<E, R>> apply(final C c) throws Exception {
                                return new Function<D, Function<E, R>>() {
                                    @Override
                                    public Function<E, R> apply(final D d) throws Exception {
                                        return new Function<E, R>() {
                                            @Override
                                            public R apply(final E e) throws Exception {
                                                return func.apply(a, b, c, d, e);
                                            }
                                        };
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C, D, E, F, R> Function<A, Function<B, Function<C, Function<D, Function<E, Function<F, R>>>>>> curry(
            final Function6<A, B, C, D, E, F, R> func) {
        return new Function<A, Function<B, Function<C, Function<D, Function<E, Function<F, R>>>>>>() {
            @Override
            public Function<B, Function<C, Function<D, Function<E, Function<F, R>>>>> apply(final A a) throws Exception {
                return new Function<B, Function<C, Function<D, Function<E, Function<F, R>>>>>() {
                    @Override
                    public Function<C, Function<D, Function<E, Function<F, R>>>> apply(final B b) throws Exception {
                        return new Function<C, Function<D, Function<E, Function<F, R>>>>() {
                            @Override
                            public Function<D, Function<E, Function<F, R>>> apply(final C c) throws Exception {
                                return new Function<D, Function<E, Function<F, R>>>() {
                                    @Override
                                    public Function<E, Function<F, R>> apply(final D d) throws Exception {
                                        return new Function<E, Function<F, R>>() {
                                            @Override
                                            public Function<F, R> apply(final E e) throws Exception {
                                                return new Function<F, R>() {
                                                    @Override
                                                    public R apply(final F f) throws Exception {
                                                        return func.apply(a, b, c, d, e, f);
                                                    }
                                                };
                                            }
                                        };
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C, D, E, F, G, R> Function<A, Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, R>>>>>>> curry(
            final Function7<A, B, C, D, E, F, G, R> func) {
        return new Function<A, Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, R>>>>>>>() {
            @Override
            public Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, R>>>>>> apply(final A a) throws Exception {
                return new Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, R>>>>>>() {
                    @Override
                    public Function<C, Function<D, Function<E, Function<F, Function<G, R>>>>> apply(final B b) throws Exception {
                        return new Function<C, Function<D, Function<E, Function<F, Function<G, R>>>>>() {
                            @Override
                            public Function<D, Function<E, Function<F, Function<G, R>>>> apply(final C c) throws Exception {
                                return new Function<D, Function<E, Function<F, Function<G, R>>>>() {
                                    @Override
                                    public Function<E, Function<F, Function<G, R>>> apply(final D d) throws Exception {
                                        return new Function<E, Function<F, Function<G, R>>>() {
                                            @Override
                                            public Function<F, Function<G, R>> apply(final E e) throws Exception {
                                                return new Function<F, Function<G, R>>() {
                                                    @Override
                                                    public Function<G, R> apply(final F f) throws Exception {
                                                        return new Function<G, R>() {
                                                            @Override
                                                            public R apply(final G g) throws Exception {
                                                                return func.apply(a, b, c, d, e, f,
                                                                        g);
                                                            }
                                                        };
                                                    }
                                                };
                                            }
                                        };
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C, D, E, F, G, H, R> Function<A, Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, R>>>>>>>> curry(
            final Function8<A, B, C, D, E, F, G, H, R> func) {
        return new Function<A, Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, R>>>>>>>>() {
            @Override
            public Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, R>>>>>>> apply(
                    final A a) {
                return new Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, R>>>>>>>() {
                    @Override
                    public Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, R>>>>>> apply(
                            final B b) {
                        return new Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, R>>>>>>() {
                            @Override
                            public Function<D, Function<E, Function<F, Function<G, Function<H, R>>>>> apply(
                                    final C c) {
                                return new Function<D, Function<E, Function<F, Function<G, Function<H, R>>>>>() {
                                    @Override
                                    public Function<E, Function<F, Function<G, Function<H, R>>>> apply(
                                            final D d) {
                                        return new Function<E, Function<F, Function<G, Function<H, R>>>>() {
                                            @Override
                                            public Function<F, Function<G, Function<H, R>>> apply(final E e) throws Exception {
                                                return new Function<F, Function<G, Function<H, R>>>() {
                                                    @Override
                                                    public Function<G, Function<H, R>> apply(final F f) throws Exception {
                                                        return new Function<G, Function<H, R>>() {
                                                            @Override
                                                            public Function<H, R> apply(final G g) throws Exception {
                                                                return new Function<H, R>() {
                                                                    @Override
                                                                    public R apply(final H h) throws Exception {
                                                                        return func.apply(a, b, c, d,
                                                                                e, f, g, h);
                                                                    }
                                                                };
                                                            }
                                                        };
                                                    }
                                                };
                                            }
                                        };
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C, D, E, F, G, H, I, R> Function<A, Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, Function<I, R>>>>>>>>> curry(
            final Function9<A, B, C, D, E, F, G, H, I, R> func) {
        return new Function<A, Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, Function<I, R>>>>>>>>>() {
            @Override
            public Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, Function<I, R>>>>>>>> apply(
                    final A a) {
                return new Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, Function<I, R>>>>>>>>() {
                    @Override
                    public Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, Function<I, R>>>>>>> apply(
                            final B b) {
                        return new Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, Function<I, R>>>>>>>() {
                            @Override
                            public Function<D, Function<E, Function<F, Function<G, Function<H, Function<I, R>>>>>> apply(
                                    final C c) {
                                return new Function<D, Function<E, Function<F, Function<G, Function<H, Function<I, R>>>>>>() {
                                    @Override
                                    public Function<E, Function<F, Function<G, Function<H, Function<I, R>>>>> apply(
                                            final D d) {
                                        return new Function<E, Function<F, Function<G, Function<H, Function<I, R>>>>>() {
                                            @Override
                                            public Function<F, Function<G, Function<H, Function<I, R>>>> apply(
                                                    final E e) {
                                                return new Function<F, Function<G, Function<H, Function<I, R>>>>() {
                                                    @Override
                                                    public Function<G, Function<H, Function<I, R>>> apply(
                                                            final F f) {
                                                        return new Function<G, Function<H, Function<I, R>>>() {
                                                            @Override
                                                            public Function<H, Function<I, R>> apply(
                                                                    final G g) {
                                                                return new Function<H, Function<I, R>>() {
                                                                    @Override
                                                                    public Function<I, R> apply(
                                                                            final H h) {
                                                                        return new Function<I, R>() {
                                                                            @Override
                                                                            public R apply(
                                                                                    final I i) throws Exception{
                                                                                return func.apply(a,
                                                                                        b, c, d, e,
                                                                                        f, g, h, i);
                                                                            }
                                                                        };
                                                                    }
                                                                };
                                                            }
                                                        };
                                                    }
                                                };
                                            }
                                        };
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }
}
