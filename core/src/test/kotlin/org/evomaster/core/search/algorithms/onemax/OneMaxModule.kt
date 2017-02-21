package org.evomaster.core.search.algorithms.onemax

import com.google.inject.*
import org.evomaster.core.EMConfig
import org.evomaster.core.search.*
import org.evomaster.core.search.service.Mutator
import org.evomaster.core.search.mutator.RandomMutator
import org.evomaster.core.search.service.*


class OneMaxModule : AbstractModule(){

    override fun configure() {
        bind(object : TypeLiteral<Sampler<OneMaxIndividual>>() {})
                .to(OneMaxSampler::class.java)
                .asEagerSingleton()

        bind(OneMaxSampler::class.java)
                .asEagerSingleton()

        bind(object : TypeLiteral<FitnessFunction<OneMaxIndividual>>() {})
                .to(OneMaxFitness::class.java)
                .asEagerSingleton()

        bind(object : TypeLiteral<Mutator<OneMaxIndividual>>() {})
                .to(object : TypeLiteral<RandomMutator<OneMaxIndividual>>() {})
                .asEagerSingleton()

        bind(object : TypeLiteral<Archive<OneMaxIndividual>>() {})
            .asEagerSingleton()

    }
}