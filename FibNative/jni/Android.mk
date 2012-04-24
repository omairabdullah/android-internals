# Defines the root to all other relative paths
# The macro function my-dir, provided by the build system,
# specifies the path of the current directory (i.e. the
# directory containing the Android.mk file itself)
LOCAL_PATH := $(call my-dir)

# Clear all LOCAL_XXX variables with the exception of
# LOCAL_PATH (this is needed because all variables are global)
include $(CLEAR_VARS)

# List all of our C files to be compiled (header file
# dependencies are automatically computed)
LOCAL_SRC_FILES := fib.c

# The name of our shared module (this name will be prepended
# by lib and postfixed by .so)
LOCAL_MODULE := fib

# Collects all LOCAL_XXX variables since "include $(CLEAR_VARS)"
#  and determines what to build (in this case a shared library)
include $(BUILD_SHARED_LIBRARY)