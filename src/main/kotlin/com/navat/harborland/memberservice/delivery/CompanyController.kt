package com.navat.harborland.memberservice.delivery

import com.navat.harborland.memberservice.delivery.model.CreateCompanyRequest
import com.navat.harborland.memberservice.delivery.model.CreateCompanyResponse
import com.navat.harborland.memberservice.delivery.model.RetrieveCompanyResponse
import org.springframework.web.bind.annotation.*

@RestController
class CompanyController(val createCompanyPresenter: CreateCompanyPresenter,
                        val retrieveCompaniesPresenter: RetrieveCompaniesPresenter
) {
    @RequestMapping(value = ["/company"], method = [RequestMethod.POST])
    fun registerCompany(@RequestBody request: CreateCompanyRequest): CreateCompanyResponse {
        return createCompanyPresenter.present(request)
    }

    @RequestMapping(value = ["/company"], method = [RequestMethod.GET])
    fun retrieveActiveCompanies(): List<RetrieveCompanyResponse> {
        return retrieveCompaniesPresenter.present()
    }
}