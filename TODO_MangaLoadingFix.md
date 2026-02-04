# Fix Plan: Manga Not Loading When Caching is Disabled

## Issue Analysis

The problem is a **NullPointerException** in `CacheManager.java`:

1. **`CacheManager` methods call `options.isCachingEnabled()` without null check** - When `options` is null, these methods throw NPE
2. **`setOptions()` is never called** - In `ReaderPanel.java`, the CacheManager is instantiated but `setOptions()` is never called, leaving `options` as null
3. **When caching is disabled via showOptions** - The NPE prevents manga from loading entirely

## Files to Edit

### 1. `src/main/java/api/CacheManager.java`
- Fix `isCached()` to handle null options
- Fix `getFromCache()` to handle null options  
- Fix `saveToCache()` to handle null options and remove debug print

### 2. `src/main/java/ui/ReaderPanel.java`
- Call `cacheManager.setOptions()` with proper options instance

## Implementation Steps

### Step 1: Fix CacheManager.java
- Add null checks for `options` in all methods that use it
- Default to caching enabled when options is null
- Remove debug print statement

### Step 2: Fix ReaderPanel.java  
- Add options field to ReaderPanel
- Initialize showOptions instance
- Pass options to cacheManager.setOptions()

## Followup Steps
- Build the project: `mvn clean compile`
- Run tests: `mvn test`
- Test manga loading with caching both enabled and disabled

