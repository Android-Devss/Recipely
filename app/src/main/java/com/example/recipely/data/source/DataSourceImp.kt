package com.example.recipely.data.source

import android.content.Context
import com.example.recipely.data.source.model.Advice
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.util.Constant.FileName.CSV_FILE_NAME
import com.example.recipely.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class DataSourceImp(private val context: Context, private val csvParser: CsvParser) : DataSource {
    private val tag = this::class.java.simpleName
    private var id = 0

    override fun getAllRecipes(): List<Recipe> {
        val recipeList = mutableListOf<Recipe>()

        context.apply {
            val inputStream = assets.open(CSV_FILE_NAME)
            val buffer = BufferedReader(InputStreamReader(inputStream))
            buffer.forEachLine {
                val currentRecipe = csvParser.parseLine(it, id++)
                recipeList.add(currentRecipe)
            }
        }
        return recipeList
    }

    override fun getAdvices(): List<Advice> =
        listOf(
            Advice(
                imgUrl = "https://qph.cf2.quoracdn.net/main-qimg-92b5f63a9bf5e1c141f515b49a16184b",
                description = "Choose whole, unprocessed foods over processed foods. This means choosing foods that are as close to their natural state as possible, such as fruits, vegetables, whole grains, and lean protein. Processed foods often contain added sugar, unhealthy fats, and artificial ingredients."
            ),
            Advice(
                imgUrl = "https://irp.cdn-website.com/ab168491/DESKTOP/jpg/soda-bottles-and-cans.jpg",
                description = "Limit your intake of sugary drinks. Sugary drinks, such as soda, juice, and sports drinks, are high in calories and low in nutrients. They can contribute to weight gain, tooth decay, and other health problems."
            ),
            Advice(
                imgUrl = "https://www.emro.who.int/images/stories/nutrition/reduce-fat-sugar-salt.jpg",
                description = "Cook more meals at home. When you cook at home, you have more control over the ingredients that go into your food. This means you can choose healthier options, such as using less salt and fat."
            ),
            Advice(
                imgUrl = "https://www.wfla.com/wp-content/uploads/sites/71/2023/04/GettyImages-FD005285.jpg?w=960&h=540&crop=1",
                description = "Read food labels carefully. When you're shopping for food, take the time to read the food labels. This will help you make informed choices about the foods you're eating."
            ),
            Advice(
                imgUrl = "https://individualfitnessllc.com/wp-content/uploads/2022/03/protein-choices.jpg",
                description = "Choose lean protein sources. Lean protein sources, such as chicken, fish, beans, and tofu, are low in saturated fat and calories. They're also a good source of protein, which is important for building and maintaining muscle mass."
            ),
            Advice(
                imgUrl = "https://www.eatthis.com/wp-content/uploads/sites/4/2023/07/fruits-and-vegetables.jpg?quality=82&strip=1&w=800",
                description = "Include plenty of vegetables in your diet. Vegetables are packed with vitamins, minerals, and fiber. They're also low in calories, making them a great way to fill up without overeating."
            ),
            Advice(
                imgUrl = "https://image-prod.iol.co.za/16x9/800/Lunch-boxes-of-nutritious-meals?source=https://xlibris.public.prod.oc.inl.infomaker.io:8443/opencontent/objects/996812c0-7970-5672-968f-ca2b4ba7face&operation=CROP&offset=190x75&resize=3810x2143&webp=true",
                description = "Don't be afraid to experiment with new recipes. There are many healthy recipes out there that are both delicious and easy to make. There's no need to stick to the same old boring meals."
            ),
            Advice(
                imgUrl = "https://static.chewba.info/images/d7f7162e-dc17-4d04-a293-09fc1e391a7a.jpg",
                description = "Don't be afraid to ask for help. If you're struggling to make healthy changes to your diet, talk to your doctor or a registered dietitian. They can help you create a plan that fits your individual needs and goals."
            ),
            Advice(
                imgUrl = "https://www.verywellhealth.com/thmb/ef6E7hyfjddPVi5p0RaeoDtvahQ=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/2507165-article-diet-and-chronic-pancreatitis-5a5e6e3996f7d00037173956.png",
                description = "Make small changes that you can stick to. Don't try to overhaul your entire diet overnight. Start by making small changes, such as adding more fruits and vegetables to your meals or cutting back on sugary drinks."
            ),
            Advice(
                imgUrl = "https://goodparentingbrighterchildren.com/wp-content/uploads/2015/04/Water-infographic-1-1.png",
                description = "Drink plenty of water. Water is essential for good health. It helps to keep your body hydrated and can help you lose weight"
            ),
            Advice(
                imgUrl = "https://www.budgetbytes.com/wp-content/uploads/2019/06/Flexible-Recipes-for-Vegetarians-and-Meat-Eaters-H.jpg",
                description = "Enjoy your food! Healthy eating doesn't have to be boring. There are many delicious and satisfying healthy recipes out there. Find the ones you enjoy and make them part of your regular diet."
            ),
            Advice(
                imgUrl = "https://healthjade.com/wp-content/uploads/2016/12/healthy-fats-list.jpg",
                description = "Choose healthy fats over unhealthy fats. Healthy fats, such as those found in avocados, nuts, and seeds, can help lower cholesterol and protect your heart health. Unhealthy fats, such as those found in processed foods and fried foods, can raise cholesterol and increase your risk of heart disease."
            ),
            Advice(
                imgUrl = "https://news.cancerresearchuk.org/wp-content/uploads/2021/05/151026-iarc-meat-rating-hero_image_for_press_release_news.jpg",
                description = "Limit your intake of red meat and processed meats. Red meat and processed meats have been linked to an increased risk of heart disease, cancer, and other chronic diseases. Instead, choose lean protein sources such as chicken, fish, beans, and lentils."
            ),
            Advice(
                imgUrl = "",
                description = "Limit your intake of red meat and processed meats. Red meat and processed meats have been linked to an increased risk of heart disease, cancer, and other chronic diseases. Instead, choose lean protein sources such as chicken, fish, beans, and lentils."
            )
        )
}