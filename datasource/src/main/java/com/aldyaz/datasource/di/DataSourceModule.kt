package com.aldyaz.datasource.di

import com.aldyaz.datasource.member.source.MemberCloudDataSource
import com.aldyaz.datasource.member.source.MemberCloudDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindMemberCloudDataSource(
        impl: MemberCloudDataSourceImpl
    ): MemberCloudDataSource

}
