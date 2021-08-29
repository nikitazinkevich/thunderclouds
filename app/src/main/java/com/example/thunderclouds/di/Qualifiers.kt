package com.example.thunderclouds.di

import javax.inject.Qualifier


@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class InterceptorQualifier(val value: String)


@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class KotlinConverter

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class BaseUrl