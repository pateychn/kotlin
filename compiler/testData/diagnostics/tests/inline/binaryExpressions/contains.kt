// !DIAGNOSTICS: -UNUSED_EXPRESSION -UNUSED_PARAMETER -UNUSED_VARIABLE -NOTHING_TO_INLINE -ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE -UNUSED_VALUE -RECURSION_IN_INLINE
inline fun <T, U> Function1<T, U>.contains(p: Function1<T, U>): Boolean {
    this in p
    p in this
    return false
}

inline fun <T, U, V> inlineFunWithInvoke(s: (p: T) -> U) {
    s in s
    s !in s
}


fun <T, U, V> Function2<T, U, V>.contains(p: Function2<T, U, V>): Boolean = false

fun <T, U, V, W> @Extension Function3<T, U, V, W>.contains(ext: @Extension Function3<T, U, V, W>): Boolean = false

inline fun <T, U, V> inlineFunWithInvoke(s: (p: T, l: U) -> U, ext: T.(p: U, l: U) -> V) {
    <!USAGE_IS_NOT_INLINABLE!>s<!> in <!USAGE_IS_NOT_INLINABLE!>s<!>
    <!USAGE_IS_NOT_INLINABLE!>s<!> !in <!USAGE_IS_NOT_INLINABLE!>s<!>

    <!USAGE_IS_NOT_INLINABLE!>ext<!> in <!USAGE_IS_NOT_INLINABLE!>ext<!>
    <!USAGE_IS_NOT_INLINABLE!>ext<!> !in <!USAGE_IS_NOT_INLINABLE!>ext<!>
}
