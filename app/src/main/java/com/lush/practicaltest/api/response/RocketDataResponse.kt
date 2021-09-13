package com.lush.practicaltest.api.response


import com.google.gson.annotations.SerializedName

class RocketDataResponse : ArrayList<RocketDataResponse.RocketDataResponseItem>(){

    data class RocketDataResponseItem(
        @SerializedName("active")
        val active: Boolean,
        @SerializedName("boosters")
        val boosters: String?,
        @SerializedName("company")
        val company: String,
        @SerializedName("cost_per_launch")
        val costPerLaunch: String?,
        @SerializedName("country")
        val country: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("diameter")
        val diameter: Diameter,
        @SerializedName("engines")
        val engines: Engines,
        @SerializedName("first_flight")
        val firstFlight: String,
        @SerializedName("first_stage")
        val firstStage: FirstStage,
        @SerializedName("flickr_images")
        val flickrImages: List<String>,
        @SerializedName("height")
        val height: Height,
        @SerializedName("id")
        val id: String,
        @SerializedName("landing_legs")
        val landingLegs: LandingLegs,
        @SerializedName("mass")
        val mass: Mass,
        @SerializedName("name")
        val name: String,
        @SerializedName("payload_weights")
        val payloadWeights: List<PayloadWeight>,
        @SerializedName("second_stage")
        val secondStage: SecondStage,
        @SerializedName("stages")
        val stages: String?,
        @SerializedName("success_rate_pct")
        val successRatePct: Int,
        @SerializedName("type")
        val type: String,
        @SerializedName("wikipedia")
        val wikipedia: String
    ) {

        data class Diameter(
            @SerializedName("feet")
            val feet: String?,
            @SerializedName("meters")
            val meters: String?
        )
    
        data class Engines(
            @SerializedName("engine_loss_max")
            val engineLossMax: Any,
            @SerializedName("isp")
            val isp: Isp,
            @SerializedName("layout")
            val layout: Any,
            @SerializedName("number")
            val number: String?,
            @SerializedName("propellant_1")
            val propellant1: String,
            @SerializedName("propellant_2")
            val propellant2: String,
            @SerializedName("thrust_sea_level")
            val thrustSeaLevel: ThrustSeaLevel,
            @SerializedName("thrust_to_weight")
            val thrustToWeight: String?,
            @SerializedName("thrust_vacuum")
            val thrustVacuum: ThrustVacuum,
            @SerializedName("type")
            val type: String,
            @SerializedName("version")
            val version: String
        ) {

            data class Isp(
                @SerializedName("sea_level")
                val seaLevel: String?,
                @SerializedName("vacuum")
                val vacuum: String?
            )
    
            data class ThrustSeaLevel(
                @SerializedName("kN")
                val kN: String?,
                @SerializedName("lbf")
                val lbf: String?
            )
    
            data class ThrustVacuum(
                @SerializedName("kN")
                val kN: String?,
                @SerializedName("lbf")
                val lbf: String?
            )
        }
    
        data class FirstStage(
            @SerializedName("burn_time_sec")
            val burnTimeSec: Any,
            @SerializedName("engines")
            val engines: String?,
            @SerializedName("fuel_amount_tons")
            val fuelAmountTons: String?,
            @SerializedName("reusable")
            val reusable: Boolean,
            @SerializedName("thrust_sea_level")
            val thrustSeaLevel: ThrustSeaLevel,
            @SerializedName("thrust_vacuum")
            val thrustVacuum: ThrustVacuum
        ) {

            data class ThrustSeaLevel(
                @SerializedName("kN")
                val kN: String?,
                @SerializedName("lbf")
                val lbf: String?
            )
    
            data class ThrustVacuum(
                @SerializedName("kN")
                val kN: String?,
                @SerializedName("lbf")
                val lbf: String?
            )
        }
    
        data class Height(
            @SerializedName("feet")
            val feet: String?,
            @SerializedName("meters")
            val meters: String?
        )
    
        data class LandingLegs(
            @SerializedName("material")
            val material: String,
            @SerializedName("number")
            val number: String?
        )
    
        data class Mass(
            @SerializedName("kg")
            val kg: String?,
            @SerializedName("lb")
            val lb: String?
        )
    
        data class PayloadWeight(
            @SerializedName("id")
            val id: String,
            @SerializedName("kg")
            val kg: String?,
            @SerializedName("lb")
            val lb: String?,
            @SerializedName("name")
            val name: String
        )
    
        data class SecondStage(
            @SerializedName("burn_time_sec")
            val burnTimeSec: Any,
            @SerializedName("engines")
            val engines: String?,
            @SerializedName("fuel_amount_tons")
            val fuelAmountTons: String?,
            @SerializedName("payloads")
            val payloads: Payloads,
            @SerializedName("reusable")
            val reusable: Boolean,
            @SerializedName("thrust")
            val thrust: Thrust
        ) {

            data class Payloads(
                @SerializedName("composite_fairing")
                val compositeFairing: CompositeFairing,
                @SerializedName("option_1")
                val option1: String
            ) {

                data class CompositeFairing(
                    @SerializedName("diameter")
                    val diameter: Diameter,
                    @SerializedName("height")
                    val height: Height
                ) {

                    data class Diameter(
                        @SerializedName("feet")
                        val feet: String?,
                        @SerializedName("meters")
                        val meters: String?
                    )

                    data class Height(
                        @SerializedName("feet")
                        val feet: String?,
                        @SerializedName("meters")
                        val meters: String?
                    )
                }
            }
    
            data class Thrust(
                @SerializedName("kN")
                val kN: String?,
                @SerializedName("lbf")
                val lbf: String?
            )
        }
    }
}