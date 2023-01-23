package com.example.core_network.impl.di

import com.example.core_network.api.NetworkApi
import com.example.core_network.api.NetworkDependencies
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [NetworkDependencies::class],
    modules = [NetworkModule::class]
)
interface NetworkComponent : NetworkApi {

    @Component.Factory
    interface Factory {
        fun create(dependencies: NetworkDependencies): NetworkComponent
    }

    companion object {

        private var component: NetworkComponent? = null

        fun initAndGet(dependencies: NetworkDependencies): NetworkComponent {
            if (component == null) {
                synchronized(NetworkComponent::class.java) {
                    if (component == null) {
                        component = DaggerNetworkComponent.factory().create(dependencies)
                    }
                }
            }
            return component!!
        }
    }
}