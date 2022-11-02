package com.example.core_network.impl.di

//object NetworkComponentHolder : ComponentHolder<NetworkApi, NetworkDependencies> {
//
//    private var component: NetworkComponent? = null
//
//    override fun init(dependencies: NetworkDependencies) {
//        if (component == null) {
//            synchronized(NetworkComponentHolder::class.java) {
//                if (component == null) {
//                    component = NetworkComponent.initAndGet(dependencies)
//                }
//            }
//        }
//    }
//
//    override fun get(): NetworkApi = getComponent()
//
//    internal fun getComponent(): NetworkComponent {
//        checkNotNull(component) { "TaskEditComponent is not initialized" }
//        return component!!
//    }
//}