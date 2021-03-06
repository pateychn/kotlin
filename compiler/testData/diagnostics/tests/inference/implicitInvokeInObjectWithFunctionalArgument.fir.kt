// !WITH_NEW_INFERENCE
// !CHECK_TYPE
// !DIAGNOSTICS: -UNUSED_PARAMETER, -UNUSED_VARIABLE

object TestClass {
    inline operator fun <T> invoke(task: () -> T) = task()
}

fun test(s: String): String {
    val a = TestClass { TestClass { TestClass } }
    a checkType { <!UNRESOLVED_REFERENCE!>_<!><TestClass>() }

    val b = TestClass { return s }
    b checkType { <!UNRESOLVED_REFERENCE!>_<!><Nothing>() }
}