/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_intel_android_loglib_LogLib */

#ifndef _Included_com_intel_android_loglib_LogLib
#define _Included_com_intel_android_loglib_LogLib
#ifdef __cplusplus
extern "C" {
#endif
#undef com_intel_android_loglib_LogLib_VERBOSE
#define com_intel_android_loglib_LogLib_VERBOSE 2L
#undef com_intel_android_loglib_LogLib_DEBUG
#define com_intel_android_loglib_LogLib_DEBUG 3L
#undef com_intel_android_loglib_LogLib_INFO
#define com_intel_android_loglib_LogLib_INFO 4L
#undef com_intel_android_loglib_LogLib_WARNING
#define com_intel_android_loglib_LogLib_WARNING 5L
#undef com_intel_android_loglib_LogLib_ERROR
#define com_intel_android_loglib_LogLib_ERROR 6L
/*
 * Class:     com_intel_android_loglib_LogLib
 * Method:    log
 * Signature: (ILjava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_intel_android_loglib_LogLib_log
  (JNIEnv *, jclass, jint, jstring, jstring);

#ifdef __cplusplus
}
#endif
#endif