package com.example.library2.views.recyclerview_expandable


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.library2.R
import java.util.*

class ExpandableRecyclerActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<LanguageData>()
    private lateinit var adapter: LanguageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expandable_recycler)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = LanguageAdapter(mList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<LanguageData>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {
        mList.add(
            LanguageData(
                "Java",
                
                "Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible."
            )
        )
        mList.add(
            LanguageData(
                "Kotlin",
                
                "Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of Kotlin's standard library depends on the Java Class Library, but type inference allows its syntax to be more concise."
            )
        )
        mList.add(
            LanguageData(
                "HTML",
                
                "The HyperText Markup Language or HTML is the standard markup language for documents designed to be displayed in a web browser."
            )
        )
        mList.add(
            LanguageData(
                "Python",
                
                "Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation."
            )
        )
        mList.add(
            LanguageData(
                "C++",
                
                "C++ is a high-level general-purpose programming language created by Danish computer scientist Bjarne Stroustrup as an extension of the C programming language, or C with Classes."

            )
        )
        mList.add(
            LanguageData(
                "Swift",
                
                "Swift is a general-purpose, multi-paradigm, compiled programming language developed by Apple Inc. and the open-source community."
            )
        )
        mList.add(
            LanguageData(
                "JavaScript",
                
                "JavaScript, often abbreviated as JS, is a programming language that is one of the core technologies of the World Wide Web, alongside HTML and CSS. As of 2022, 98% of websites use JavaScript on the client side for webpage behavior, often incorporating third-party libraries."
            )
        )
        mList.add(
            LanguageData(
                "C#",
                
                "C# is a general-purpose, high-level multi-paradigm programming language. C# encompasses static typing, strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented, and component-oriented programming disciplines."
            )
        )
    }
}