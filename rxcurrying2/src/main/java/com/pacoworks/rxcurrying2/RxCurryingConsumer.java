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

import hu.akarnokd.rxjava2.functions.Consumer3;
import hu.akarnokd.rxjava2.functions.Consumer4;
import hu.akarnokd.rxjava2.functions.Consumer5;
import hu.akarnokd.rxjava2.functions.Consumer6;
import hu.akarnokd.rxjava2.functions.Consumer7;
import hu.akarnokd.rxjava2.functions.Consumer8;
import hu.akarnokd.rxjava2.functions.Consumer9;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Helper class to curry ActionN objects
 *
 * @author pakoito
 */
public class RxCurryingConsumer {
    private RxCurryingConsumer() {
        // No instances
    }

    public static <A, B> Function<A, Consumer<B>> curry(final BiConsumer<A, B> action) {
        return new Function<A, Consumer<B>>() {
            @Override
            public Consumer<B> apply(final A a) throws Exception {
                return new Consumer<B>() {
                    @Override
                    public void accept(final B b) throws Exception {
                        action.accept(a, b);
                    }
                };
            }
        };
    }

    public static <A, B, C> Function<A, Function<B, Consumer<C>>> curry(final Consumer3<A, B, C> action) {
        return new Function<A, Function<B, Consumer<C>>>() {
            @Override
            public Function<B, Consumer<C>> apply(final A a) throws Exception {
                return new Function<B, Consumer<C>>() {
                    @Override
                    public Consumer<C> apply(final B b) throws Exception {
                        return new Consumer<C>() {
                            @Override
                            public void accept(final C c) throws Exception {
                                action.accept(a, b, c);
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C, D> Function<A, Function<B, Function<C, Consumer<D>>>> curry(
            final Consumer4<A, B, C, D> action) {
        return new Function<A, Function<B, Function<C, Consumer<D>>>>() {
            @Override
            public Function<B, Function<C, Consumer<D>>> apply(final A a) throws Exception {
                return new Function<B, Function<C, Consumer<D>>>() {
                    @Override
                    public Function<C, Consumer<D>> apply(final B b) throws Exception {
                        return new Function<C, Consumer<D>>() {
                            @Override
                            public Consumer<D> apply(final C c) throws Exception {
                                return new Consumer<D>() {
                                    @Override
                                    public void accept(final D d) throws Exception {
                                        action.accept(a, b, c, d);
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C, D, E> Function<A, Function<B, Function<C, Function<D, Consumer<E>>>>> curry(
            final Consumer5<A, B, C, D, E> action) {
        return new Function<A, Function<B, Function<C, Function<D, Consumer<E>>>>>() {
            @Override
            public Function<B, Function<C, Function<D, Consumer<E>>>> apply(final A a) throws Exception {
                return new Function<B, Function<C, Function<D, Consumer<E>>>>() {
                    @Override
                    public Function<C, Function<D, Consumer<E>>> apply(final B b) throws Exception {
                        return new Function<C, Function<D, Consumer<E>>>() {
                            @Override
                            public Function<D, Consumer<E>> apply(final C c) throws Exception {
                                return new Function<D, Consumer<E>>() {
                                    @Override
                                    public Consumer<E> apply(final D d) throws Exception {
                                        return new Consumer<E>() {
                                            @Override
                                            public void accept(final E e) throws Exception {
                                                action.accept(a, b, c, d, e);
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

    public static <A, B, C, D, E, F> Function<A, Function<B, Function<C, Function<D, Function<E, Consumer<F>>>>>> curry(
            final Consumer6<A, B, C, D, E, F> action) {
        return new Function<A, Function<B, Function<C, Function<D, Function<E, Consumer<F>>>>>>() {
            @Override
            public Function<B, Function<C, Function<D, Function<E, Consumer<F>>>>> apply(final A a) throws Exception {
                return new Function<B, Function<C, Function<D, Function<E, Consumer<F>>>>>() {
                    @Override
                    public Function<C, Function<D, Function<E, Consumer<F>>>> apply(final B b) throws Exception {
                        return new Function<C, Function<D, Function<E, Consumer<F>>>>() {
                            @Override
                            public Function<D, Function<E, Consumer<F>>> apply(final C c) throws Exception {
                                return new Function<D, Function<E, Consumer<F>>>() {
                                    @Override
                                    public Function<E, Consumer<F>> apply(final D d) throws Exception {
                                        return new Function<E, Consumer<F>>() {
                                            @Override
                                            public Consumer<F> apply(final E e) throws Exception {
                                                return new Consumer<F>() {
                                                    @Override
                                                    public void accept(final F f) throws Exception {
                                                        action.accept(a, b, c, d, e, f);
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

    public static <A, B, C, D, E, F, G> Function<A, Function<B, Function<C, Function<D, Function<E, Function<F, Consumer<G>>>>>>> curry(
            final Consumer7<A, B, C, D, E, F, G> action) {
        return new Function<A, Function<B, Function<C, Function<D, Function<E, Function<F, Consumer<G>>>>>>>() {
            @Override
            public Function<B, Function<C, Function<D, Function<E, Function<F, Consumer<G>>>>>> apply(final A a) throws Exception {
                return new Function<B, Function<C, Function<D, Function<E, Function<F, Consumer<G>>>>>>() {
                    @Override
                    public Function<C, Function<D, Function<E, Function<F, Consumer<G>>>>> apply(final B b) throws Exception {
                        return new Function<C, Function<D, Function<E, Function<F, Consumer<G>>>>>() {
                            @Override
                            public Function<D, Function<E, Function<F, Consumer<G>>>> apply(final C c) throws Exception {
                                return new Function<D, Function<E, Function<F, Consumer<G>>>>() {
                                    @Override
                                    public Function<E, Function<F, Consumer<G>>> apply(final D d) throws Exception {
                                        return new Function<E, Function<F, Consumer<G>>>() {
                                            @Override
                                            public Function<F, Consumer<G>> apply(final E e) throws Exception {
                                                return new Function<F, Consumer<G>>() {
                                                    @Override
                                                    public Consumer<G> apply(final F f) throws Exception {
                                                        return new Consumer<G>() {
                                                            @Override
                                                            public void accept(final G g) throws Exception {
                                                                action.accept(a, b, c, d, e, f, g);
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

    public static <A, B, C, D, E, F, G, H> Function<A, Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, Consumer<H>>>>>>>> curry(
            final Consumer8<A, B, C, D, E, F, G, H> action) {
        return new Function<A, Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, Consumer<H>>>>>>>>() {
            @Override
            public Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, Consumer<H>>>>>>> apply(
                    final A a) throws Exception {
                return new Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, Consumer<H>>>>>>>() {
                    @Override
                    public Function<C, Function<D, Function<E, Function<F, Function<G, Consumer<H>>>>>> apply(
                            final B b) throws Exception {
                        return new Function<C, Function<D, Function<E, Function<F, Function<G, Consumer<H>>>>>>() {
                            @Override
                            public Function<D, Function<E, Function<F, Function<G, Consumer<H>>>>> apply(
                                    final C c) throws Exception {
                                return new Function<D, Function<E, Function<F, Function<G, Consumer<H>>>>>() {
                                    @Override
                                    public Function<E, Function<F, Function<G, Consumer<H>>>> apply(
                                            final D d) throws Exception {
                                        return new Function<E, Function<F, Function<G, Consumer<H>>>>() {
                                            @Override
                                            public Function<F, Function<G, Consumer<H>>> apply(final E e) throws Exception {
                                                return new Function<F, Function<G, Consumer<H>>>() {
                                                    @Override
                                                    public Function<G, Consumer<H>> apply(final F f) throws Exception {
                                                        return new Function<G, Consumer<H>>() {
                                                            @Override
                                                            public Consumer<H> apply(final G g) throws Exception {
                                                                return new Consumer<H>() {
                                                                    @Override
                                                                    public void accept(final H h) throws Exception {
                                                                        action.accept(a, b, c, d, e,
                                                                                f, g, h);
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

    public static <A, B, C, D, E, F, G, H, I> Function<A, Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, Consumer<I>>>>>>>>> curry(
            final Consumer9<A, B, C, D, E, F, G, H, I> action) {
        return new Function<A, Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, Consumer<I>>>>>>>>>() {
            @Override
            public Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, Consumer<I>>>>>>>> apply(
                    final A a) throws Exception {
                return new Function<B, Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, Consumer<I>>>>>>>>() {
                    @Override
                    public Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, Consumer<I>>>>>>> apply(
                            final B b) throws Exception {
                        return new Function<C, Function<D, Function<E, Function<F, Function<G, Function<H, Consumer<I>>>>>>>() {
                            @Override
                            public Function<D, Function<E, Function<F, Function<G, Function<H, Consumer<I>>>>>> apply(
                                    final C c) throws Exception {
                                return new Function<D, Function<E, Function<F, Function<G, Function<H, Consumer<I>>>>>>() {
                                    @Override
                                    public Function<E, Function<F, Function<G, Function<H, Consumer<I>>>>> apply(
                                            final D d) throws Exception {
                                        return new Function<E, Function<F, Function<G, Function<H, Consumer<I>>>>>() {
                                            @Override
                                            public Function<F, Function<G, Function<H, Consumer<I>>>> apply(
                                                    final E e) throws Exception {
                                                return new Function<F, Function<G, Function<H, Consumer<I>>>>() {
                                                    @Override
                                                    public Function<G, Function<H, Consumer<I>>> apply(
                                                            final F f) throws Exception {
                                                        return new Function<G, Function<H, Consumer<I>>>() {
                                                            @Override
                                                            public Function<H, Consumer<I>> apply(
                                                                    final G g) throws Exception {
                                                                return new Function<H, Consumer<I>>() {
                                                                    @Override
                                                                    public Consumer<I> apply(
                                                                            final H h) throws Exception {
                                                                        return new Consumer<I>() {
                                                                            @Override
                                                                            public void accept(
                                                                                    final I i) throws Exception {
                                                                                action.accept(a, b, c,
                                                                                        d, e, f, g,
                                                                                        h, i);
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
