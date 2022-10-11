package com.example.library2

data class CopyButtonDataModel(var valueToBeCopied: String, var copyButtonText: String?,
                               var isCopied: Boolean, var onCopyButtonClicked: () -> Unit)
