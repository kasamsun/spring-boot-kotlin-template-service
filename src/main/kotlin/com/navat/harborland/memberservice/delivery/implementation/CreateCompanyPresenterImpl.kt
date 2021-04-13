package com.navat.harborland.memberservice.delivery.implementation

import com.navat.harborland.memberservice.delivery.CreateCompanyPresenter
import com.navat.harborland.memberservice.delivery.model.CreateCompanyRequest
import com.navat.harborland.memberservice.delivery.model.CreateCompanyResponse
import com.navat.harborland.memberservice.domain.CreateCompanyUseCase
import com.navat.harborland.memberservice.domain.entity.Company
import com.navat.harborland.memberservice.domain.entity.CompanyRegistration
import com.navat.harborland.memberservice.domain.entity.RegistrationStatus
import java.util.*
import javax.inject.Named

@Named
class CreateCompanyPresenterImpl(private val usecase: CreateCompanyUseCase): CreateCompanyPresenter {
    override fun present(companyRequest: CreateCompanyRequest): CreateCompanyResponse {
        //convert request model to usecase specific form that has meaning
        val company = Company(
            id = null,
            name = companyRequest.name,
            link = companyRequest.website,
            missionStatement = companyRequest.missionStatement,
            logo = companyRequest.logo,
            registration = CompanyRegistration(
                date = Date().toString(),
                status = RegistrationStatus.ACCEPTED
            )
        )

        //use case returns build domain result
        val result = usecase.execute(company)

        // convert domain result to response model
        val response = CreateCompanyResponse()
        response.id = UUID.fromString(result.id)
        response.name = result.name
        response.link = result.link
        response.missionStatement = result.missionStatement
        response.logo = result.logo
        response.registration = result.registration

        return response
    }
}