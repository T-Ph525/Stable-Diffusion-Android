package com.shifthackz.aisdv1.domain.datasource

import com.shifthackz.aisdv1.domain.entity.AiGenerationResult
import com.shifthackz.aisdv1.domain.entity.ImageToImagePayload
import com.shifthackz.aisdv1.domain.entity.TextToImagePayload
import io.reactivex.rxjava3.core.Single

sealed interface HuggingFaceGenerationDataSource {
    interface Remote : HuggingFaceGenerationDataSource {
        fun validateApiKey(): Single<Boolean>
        fun textToImage(
            endpoint: String,
            payload: TextToImagePayload,
        ): Single<AiGenerationResult>

        fun imageToImage(
            endpoint: String,
            payload: ImageToImagePayload,
        ): Single<AiGenerationResult>
    }
}
