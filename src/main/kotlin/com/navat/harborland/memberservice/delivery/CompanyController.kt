package com.navat.harborland.memberservice.delivery

import com.navat.harborland.memberservice.TestController
import com.navat.harborland.memberservice.delivery.model.CreateCompanyRequest
import com.navat.harborland.memberservice.delivery.model.CreateCompanyResponse
import com.navat.harborland.memberservice.delivery.model.RetrieveCompanyResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
class CompanyController(val createCompanyPresenter: CreateCompanyPresenter,
                        val retrieveCompaniesPresenter: RetrieveCompaniesPresenter
) {

    var log: Logger = LoggerFactory.getLogger(CompanyController::class.java)

    @RequestMapping(value = ["/company"], method = [RequestMethod.POST])
    fun registerCompany(@RequestBody request: CreateCompanyRequest): CreateCompanyResponse {
        log.info("### Insert company ###")
        return createCompanyPresenter.present(request)
    }

    @RequestMapping(value = ["/company"], method = [RequestMethod.GET])
    fun retrieveActiveCompanies(): List<RetrieveCompanyResponse> {
        log.info("### find all company ###")
        return retrieveCompaniesPresenter.present()
    }
}