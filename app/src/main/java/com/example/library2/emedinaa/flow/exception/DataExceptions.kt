package com.example.library2.emedinaa.flow.exception

/**
 * @author : Eduardo Medina
 */
class ServiceException(message:String?) : Exception(message)
class EmptyListException : Exception()
class ConnectionException : Exception()