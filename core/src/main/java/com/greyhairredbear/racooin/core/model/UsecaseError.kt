package com.greyhairredbear.racooin.core.model

sealed class UsecaseError

object ComputationFailedError: UsecaseError()

object PersistenceError: UsecaseError()

abstract class ApiClientError: UsecaseError()
object ApiCallFailed: ApiClientError()
