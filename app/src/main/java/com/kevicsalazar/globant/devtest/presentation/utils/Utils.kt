package com.kevicsalazar.globant.devtest.presentation.utils

import android.widget.TextView
import androidx.core.text.HtmlCompat


fun TextView.setHtmlText(text: String) {
    setText(HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_COMPACT), TextView.BufferType.SPANNABLE)
}
