package com.navat.harborland.memberservice.delivery.implementation

import com.navat.harborland.memberservice.delivery.RetrieveCompaniesPresenter
import com.navat.harborland.memberservice.delivery.model.RetrieveCompanyResponse
import com.navat.harborland.memberservice.domain.RetrieveActiveCompaniesUseCase
import com.navat.harborland.memberservice.domain.entity.Company
import com.navat.harborland.memberservice.repository.model.MongoCompany
import java.util.*
import javax.inject.Named

@Named
class RetrieveCompaniesImpl(val usecase: RetrieveActiveCompaniesUseCase): RetrieveCompaniesPresenter {
    override fun present(): List<RetrieveCompanyResponse> {
        val retrievedCompanies = usecase.execute()
        val responseList: MutableList<RetrieveCompanyResponse> = mutableListOf()

        //convert domain result to response model
        for (companyItem: Any in retrievedCompanies) {

            val companyResponseItem = RetrieveCompanyResponse()

            //Need to typ check for mongo
            if (companyItem is Company) {
                val item: Company = companyItem

                companyResponseItem.id = UUID.fromString(item.id)
                companyResponseItem.name = item.name
                companyResponseItem.link = item.link
                companyResponseItem.missionStatement = item.missionStatement
                companyResponseItem.logo = item.logo
            }

            if (companyItem is MongoCompany) {
                val item: MongoCompany = companyItem

                companyResponseItem.id = item.id
                companyResponseItem.name = item.name
                companyResponseItem.link = item.link
                companyResponseItem.missionStatement = item.missionStatement
                companyResponseItem.logo = item.logo
            }


            responseList.add(companyResponseItem)
        }

        return responseList
    }
}